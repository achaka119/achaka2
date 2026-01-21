package model;

public class WorkoutSession {
    private int sessionId;
    private Member member;
    private String trainerName;
    private int durationMinutes;
    private boolean completed;

    public WorkoutSession(int sessionId, Member member, String trainerName, int durationMinutes, boolean completed) {
        this.sessionId = sessionId;
        this.member = member;
        this.trainerName = trainerName;
        this.durationMinutes = durationMinutes;
        this.completed = completed;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes > 0) this.durationMinutes = durationMinutes;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void extend(int extraMinutes) {
        if (completed || extraMinutes <= 0) return;
        durationMinutes += extraMinutes;
    }

    public void complete() {
        completed = true;
    }
}

