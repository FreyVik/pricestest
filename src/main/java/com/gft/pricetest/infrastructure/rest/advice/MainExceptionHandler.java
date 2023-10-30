package com.gft.pricetest.infrastructure.rest.advice;

import com.gft.pricetest.application.model.AppTariffRequest;
import com.gft.pricetest.infrastructure.adapter.exception.NotFoundTariffPriceException;
import com.gft.pricetest.infrastructure.models.ErrorResponseDTO;
import com.gft.pricetest.utils.DateTimeFormatterUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.format.DateTimeParseException;

import static com.gft.pricetest.utils.DateTimeFormatterUtil.DATE_TIME_FORMAT;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(NotFoundTariffPriceException.class)
    public ResponseEntity<ErrorResponseDTO> notFoundTariffPrice(NotFoundTariffPriceException noPriceEx) {
        ErrorResponseDTO notTariffPriceErrorDTO = new ErrorResponseDTO();
        notTariffPriceErrorDTO.setCode(HttpStatus.NOT_FOUND.value());
        notTariffPriceErrorDTO.description(creteNotFoundPriceDescription(noPriceEx.getAppTariffRequest()));

        return new ResponseEntity<>(notTariffPriceErrorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponseDTO> genericError(MissingServletRequestParameterException missingParameterException) {
        ErrorResponseDTO notValidErrorDTO = new ErrorResponseDTO();
        notValidErrorDTO.setCode(HttpStatus.BAD_REQUEST.value());
        notValidErrorDTO.setDescription(String.format("Parameter [%s] not found", missingParameterException.getParameterName()));


        return new ResponseEntity<>(notValidErrorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErrorResponseDTO> genericError(DateTimeParseException dateTimeParseException) {
        ErrorResponseDTO notValidErrorDTO = new ErrorResponseDTO();
        notValidErrorDTO.setCode(HttpStatus.BAD_REQUEST.value());
        notValidErrorDTO.setDescription(String.format("'%s' doesn't comply with date format %s", dateTimeParseException.getParsedString(), DATE_TIME_FORMAT));

        return new ResponseEntity<>(notValidErrorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> genericError(MethodArgumentTypeMismatchException parameterTypeException) {
        ErrorResponseDTO notValidErrorDTO = new ErrorResponseDTO();
        notValidErrorDTO.setCode(HttpStatus.BAD_REQUEST.value());
        notValidErrorDTO.setDescription(String.format("Parameter [%s] is not %s",
                parameterTypeException.getParameter().getParameterName(),
                parameterTypeException.getParameter().getParameterType().getTypeName()));

        return new ResponseEntity<>(notValidErrorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> genericError(RuntimeException e) {
        ErrorResponseDTO customErrorMessage = new ErrorResponseDTO();
        customErrorMessage.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        customErrorMessage.setDescription("Unexpected error");

        e.printStackTrace();

        return new ResponseEntity<>(customErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String creteNotFoundPriceDescription(AppTariffRequest appTariffRequest) {
        return String.format("Price for product %d not found at %s"
                , appTariffRequest.getProductId()
                , DateTimeFormatterUtil.parseToString(appTariffRequest.getAppliedDate()));
    }
}
