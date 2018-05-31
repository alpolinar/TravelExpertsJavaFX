package model;

public class AgentUsers {
    private int AgentUserId;
    private String AgentUsername;
    private String AgentPassword;
    private int AgentId;
    
    public AgentUsers(){}
    
    public AgentUsers(int AgentUserId, String AgentUsername, String AgentPassword, int AgentId) {
        this.AgentUserId = AgentUserId;
        this.AgentUsername = AgentUsername;
        this.AgentPassword = AgentPassword;
        this.AgentId = AgentId;
    }

    public int getAgentUserId() {
        return AgentUserId;
    }

    public void setAgentUserId(int AgentUserId) {
        this.AgentUserId = AgentUserId;
    }

    public String getAgentUsername() {
        return AgentUsername;
    }

    public void setAgentUsername(String AgentUsername) {
        this.AgentUsername = AgentUsername;
    }

    public String getAgentPassword() {
        return AgentPassword;
    }

    public void setAgentPassword(String AgentPassword) {
        this.AgentPassword = AgentPassword;
    }

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int AgentId) {
        this.AgentId = AgentId;
    }
}
