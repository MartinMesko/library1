package sk.itvkurze.Lekcia_21;

import java.util.List;

public class RentalEntries {
    private String memberId;
    private String rentedDate;
    private String returnDate;
    private String titleId;
    private String timesProlongued;
    private String titleType;

    public RentalEntries(String memberId, String rentedDate, String returnDate, String titleId, String timesProlongued, String titleType) {
        this.memberId = memberId;
        this.rentedDate = rentedDate;
        this.returnDate = returnDate;
        this.titleId = titleId;
        this.timesProlongued = timesProlongued;
        this.titleType = titleType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(String rentedDate) {
        this.rentedDate = rentedDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTimesProlongued() {
        return timesProlongued;
    }

    public void setTimesProlongued(String timesProlongued) {
        this.timesProlongued = timesProlongued;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }
}
