/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.time.LocalDate;

/**
 *
 * @author Nayeem Khan
 */
class HelpAndSafety {
    private int id;
    private String issue;
    private String describeIssue;
    private LocalDate date;

    public HelpAndSafety(int id, String issue, String describeIssue, LocalDate date) {
        this.id = id;
        this.issue = issue;
        this.describeIssue = describeIssue;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescribeIssue() {
        return describeIssue;
    }

    public void setDescribeIssue(String describeIssue) {
        this.describeIssue = describeIssue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
