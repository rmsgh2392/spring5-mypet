package com.mypet.web.cat;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Lazy
public class Cats {
	private String birth, sex, name, hairlength, haircolor, species, size, style, illhistory;
}
