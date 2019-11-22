package com.mypet.web.brd;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Lazy
@Component
public class Articles {
	private String articleseq, image , uid, comments, msg, rating, category, hashtag, content ;
}
