package sk.itvkurze.Lekcia_21;

public class QueueItems {
    private String memberId;
    private String timeAdded;
    private String titleId;
    private String isResovled;

    public QueueItems(String memberId, String timeAdded, String titleId, String isResovled) {
        this.memberId = memberId;
        this.timeAdded = timeAdded;
        this.titleId = titleId;
        this.isResovled = isResovled;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(String timeAdded) {
        this.timeAdded = timeAdded;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getIsResovled() {
        return isResovled;
    }

    public void setIsResovled(String isResovled) {
        this.isResovled = isResovled;
    }
}
