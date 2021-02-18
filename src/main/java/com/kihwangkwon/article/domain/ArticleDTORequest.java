package com.kihwangkwon.article.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTORequest {
	private long userId;
	private String title;
	private String body;
	private String board;
	private long originArticle;
	private long targetArticle;
	private int depth;
}
