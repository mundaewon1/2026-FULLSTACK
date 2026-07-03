package com.the703.llmrag;

public record Choice(
		int index, Message message, String finish_reason
) {}


//@Value  - import java.util.List;
//--------------------------------- 아래속성
//@Getter
//@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) - 모든필드를 private final 변경
//@AllArgsConstructor 
//@ToString 
//@EqualsAndHashCode.