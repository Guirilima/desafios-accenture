package br.com.thundercoders.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.thundercoders.model.dto.DtoErro;

@RestControllerAdvice
public class ErroValidacaoController {

	@Autowired
	private MessageSource message;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<DtoErro> handlerErro(MethodArgumentNotValidException exception) {
		List<DtoErro> erros = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.stream().forEach(e -> {
			String mensagem = message.getMessage(e, LocaleContextHolder.getLocale());
			erros.add(new DtoErro(e.getField(), mensagem));
		});
		return erros;
	}

}
