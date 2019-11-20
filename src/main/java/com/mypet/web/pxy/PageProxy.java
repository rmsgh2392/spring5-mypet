package com.mypet.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("pager") @Lazy
public class PageProxy extends Proxy{
	@Autowired CrawlingProxy crawler;
	
	private int rowCount, startRow, endRow, 
				pageSize, pageCount, startPage, endPage, currPage,
				blockSize, blockCount, currBlock, prevBlock, nextBlock;
	private boolean existPrev, existNext;
	private String search;
	
	public void paging() {
		//외부에서 주입되는 값 rowCount , pageSize , blockSize , currPage
		//카운트들은 경우의 수가 생김
		printer("크롤링한 데이터 사이즈 :" +rowCount);
		pageCount = (rowCount % pageSize!=0 ) ? (rowCount / pageSize)+1 :  rowCount / pageSize;
		blockCount = (pageCount % blockSize !=0) ? (pageCount / blockSize)+1 : pageCount / blockSize;
		startRow = currPage * pageSize;
//		endRow = (rowCount%pageSize !=0) ? rowCount : (currPage * pageSize)-1;
		endRow = (currPage != (pageCount-1)) ? startRow + (pageSize-1) : rowCount -1;
		currBlock = currPage / blockSize;
		startPage = currBlock * blockSize;
		endPage = (currBlock != (blockCount-1)) ? startPage +(blockSize-1): pageCount -1 ;
		nextBlock  = startPage + blockSize;
		prevBlock  = startPage - blockSize;
		existPrev = currBlock !=0;
		existNext = currBlock != (blockCount-1);

	}
}
