package ahmed.mabrouk.gestiondestock.handler;

import java.util.ArrayList;
import java.util.List;

import ahmed.mabrouk.gestiondestock.exeption.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
	
	 private Integer httpCode;

	  private ErrorCodes code;

	  private String message;
	  
	  @Builder.Default
	  private List<String> errors = new ArrayList<>();

}
