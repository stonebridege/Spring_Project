package com.stonebridge.domain;

import java.util.List;
import java.util.Map;

public class HappyTeam {
    private String teamName;
    private Integer memberCount;
    private Double memberSalary;
    private List<String> memNameList;
    private Map<String, String> managerMap;

    public Map<String, String> getManagerMap() {
        return managerMap;
    }

    public void setManagerMap(Map<String, String> managerMap) {
        this.managerMap = managerMap;
    }

    @Override
    public String toString() {
        return "HappyTeam{" +
                "teamName='" + teamName + '\'' +
                ", memberCount=" + memberCount +
                ", memberSalary=" + memberSalary +
                ", memNameList=" + memNameList +
                '}';
    }

    public HappyTeam(String teamName, Integer memberCount, Double memberSalary, List<String> memNameList) {
        this.teamName = teamName;
        this.memberCount = memberCount;
        this.memberSalary = memberSalary;
        this.memNameList = memNameList;
    }

    public HappyTeam(String teamName, Integer memberCount, Double memberSalary) {
        this.teamName = teamName;
        this.memberCount = memberCount;
        this.memberSalary = memberSalary;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Double getMemberSalary() {
        return memberSalary;
    }

    public void setMemberSalary(Double memberSalary) {
        this.memberSalary = memberSalary;
    }

    public List<String> getMemNameList() {
        return memNameList;
    }

    public void setMemNameList(List<String> memNameList) {
        this.memNameList = memNameList;
    }

    public HappyTeam() {
    }
}
