package com.mypet.web.dog;

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
public class Dogs {
	private String species, size, name, hairLength, color, sex, breed, age, birthdate,vaccin;
}
