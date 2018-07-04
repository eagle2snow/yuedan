package com.gm.base.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gm.base.model.sys.User;
import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.util.DataNature;
import com.gm.gencode.util.FieldType;

/**
 * 提现
 */
@M("提现")
@Table(name = "t_draw")
@Entity(name = "draw")
@SuppressWarnings("serial")
public class Draw extends Model {

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Member.class)
    private Member member;

    private String cardUser;// 持卡人
    private String cardNo;// 银行卡账号

    @FormField(type = FieldType.TEXTINPUT, label = "提现金额")
    private BigDecimal amount;
    @FormField(type = FieldType.RADIO, label = "状态", data = "1|待审核,2|拒绝提现,3|待打款,4|已打款,5|已作废")
    private Integer status;
    @FormField(type = FieldType.TEXTINPUT, label = "银行流水号")
    private String flowNo;
    @FormField(type = FieldType.TEXTAREA, label = "备注")
    private String oprator;

    private Date dealDate;// 处理时间

    private String remark;

    @ManyToOne
    public Member getMember()
    {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getFlowNo()
    {
        return flowNo;
    }

    public void setFlowNo(String flowNo)
    {
        this.flowNo = flowNo;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }


    public String getOprator()
    {
        return oprator;
    }

    public void setOprator(String oprator)
    {
        this.oprator = oprator;
    }

    public Date getDealDate()
    {
        return dealDate;
    }

    public void setDealDate(Date dealDate)
    {
        this.dealDate = dealDate;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getCardUser()
    {
        return cardUser;
    }

    public void setCardUser(String cardUser)
    {
        this.cardUser = cardUser;
    }

}
