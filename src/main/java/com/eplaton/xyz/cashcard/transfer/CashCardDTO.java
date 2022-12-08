package com.eplaton.xyz.cashcard.transfer;

import java.math.BigDecimal;

class Constants {
	public static final String BLANK ="";
	public static final long ZERO = 0L;
}

public class CashCardDTO
{
    private String bankType = Constants.BLANK;
    private String bankCode = Constants.BLANK;
    private String primaryAccountNo = Constants.BLANK;
    private String type = Constants.BLANK;
    private String feeCcy = Constants.BLANK;
    private String registerDate = Constants.BLANK;
    private String registerTime = Constants.BLANK;
    private String registerBy = Constants.BLANK;
    private String remark = Constants.BLANK;
    private String lastUpdateDate = Constants.BLANK;
    private String lastUpdateTime = Constants.BLANK;
    private String lastUpdateUserID = Constants.BLANK;
    private String MISSendDate = Constants.BLANK;
    private String issueDate = Constants.BLANK;
    private String amendReason = Constants.BLANK;
    private String registerType = Constants.BLANK;
    private String primaryCurrency = Constants.BLANK;
    private String secondaryCurrency = Constants.BLANK;
    private String tenaryCurrency = Constants.BLANK;
    private long secondaryBalance = Constants.ZERO;
    private int recordCount;
    private String targetAccountNo = Constants.BLANK;
    private String targetCIFName = Constants.BLANK;

}
