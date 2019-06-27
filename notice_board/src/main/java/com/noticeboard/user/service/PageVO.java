package com.noticeboard.user.service;

import org.springframework.stereotype.Service;

@Service("pageVO")
public class PageVO {
	private static final int FIT_STARTING_FROM_ZERO = 1;
	private static final int REMAINER_ZERO = 0;
	private static final int BLOCK_SIZE_MINUS_START_BLOCK = 4;
	private static final int MAXIMUM_PAGE_IN_FIRST_BLOCK = 6;
	private static final int MINIMUM_PAGE_NUMBER = 0;
	private static final int PAGE_COUNT_IN_A_BLOCK = 5;
	private int totalNoticeCount;
	private int currentPageNumber; 
	private int noticeCountInAPage = 10; 
	private int startPageInBlock = 1; 
	private int endPageInBlock = 5; 
	private boolean previousArrow = false; 
	private boolean nextArrow; 
	private int currentBlock; 
	private int lastBlock; 
	
	public void setting(int CurrentPageNumber, int totalNoticeCount) {
		setTotalNoticeCount(totalNoticeCount);
		setCurrentPageNumber(CurrentPageNumber - FIT_STARTING_FROM_ZERO);
		setCurrentBlock(CurrentPageNumber);
		setLastBlock(getTotalNoticeCount());
		previousNext(CurrentPageNumber);
		setStartPageInBlock(getCurrentBlock());
		setEndPageInBlock(getLastBlock(), getCurrentBlock());
	}

	public void previousNext(int currentPageNumber) {
		if(isFirstBlock(currentPageNumber)) {
			setPreviousArrow(false);
			setNextArrow(true);
		}else if(isLastBlock()){
			setPreviousArrow(true);
			setNextArrow(false);
		}else{
			setPreviousArrow(true);
			setNextArrow(true);
		}
	}
	
	private int calculateTotalPage(int totalNoticeCount, int noticeCountInAPage) {
		int totalPage = totalNoticeCount / noticeCountInAPage;
		if (totalNoticeCount % noticeCountInAPage > REMAINER_ZERO) {
			totalPage++;
		}
		return totalPage;
	}

	public int getTotalNoticeCount() {
		return totalNoticeCount;
	}

	public void setTotalNoticeCount(int totalNoticeCount) {
		this.totalNoticeCount = totalNoticeCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public int getNoticeCountInAPage() {
		return noticeCountInAPage;
	}

	public void setNoticeCountInAPage(int noticeCountInAPage) {
		this.noticeCountInAPage = noticeCountInAPage;
	}

	public int getStartPageInBlock() {
		return startPageInBlock;
	}

	public void setStartPageInBlock(int currentBlock) {
		this.startPageInBlock = (currentBlock * PAGE_COUNT_IN_A_BLOCK) - (PAGE_COUNT_IN_A_BLOCK - FIT_STARTING_FROM_ZERO);
	}

	public int getEndPageInBlock() {
		return endPageInBlock;
	}

	public void setEndPageInBlock(int getLastBlock, int getCurrentBlock) {
		if (getLastBlock == getCurrentBlock) {
			this.endPageInBlock = calculateTotalPage(getTotalNoticeCount(), getNoticeCountInAPage());
		} else {
			this.endPageInBlock = getStartPageInBlock() + BLOCK_SIZE_MINUS_START_BLOCK;
		}
	}

	public boolean isPreviousArrow() {
		return previousArrow;
	}

	public void setPreviousArrow(boolean previousArrow) {
		this.previousArrow = previousArrow;
	}

	public boolean isNextArrow() {
		return nextArrow;
	}

	public void setNextArrow(boolean nextArrow) {
		this.nextArrow = nextArrow;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int currentPageNumber) {
		this.currentBlock = currentPageNumber / PAGE_COUNT_IN_A_BLOCK;
		if (currentPageNumber % PAGE_COUNT_IN_A_BLOCK > REMAINER_ZERO) {
			this.currentBlock++;
		}
	}

	public int getLastBlock() {
		return lastBlock;
	}

	public void setLastBlock(int totalNoticeCount) {
		this.lastBlock = totalNoticeCount / (PAGE_COUNT_IN_A_BLOCK * this.noticeCountInAPage);
		if (totalNoticeCount % (PAGE_COUNT_IN_A_BLOCK * this.noticeCountInAPage) > REMAINER_ZERO) {
			this.lastBlock++;
		}
	}
	
	private boolean isLastBlock() {
		return getLastBlock() == getCurrentBlock();
	}

	private boolean isFirstBlock(int currentPageNumber) {
		return currentPageNumber>MINIMUM_PAGE_NUMBER && currentPageNumber<MAXIMUM_PAGE_IN_FIRST_BLOCK;
	}
}
