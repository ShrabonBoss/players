package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_states")
public class Player {

    @Id
    @Column(name = "name", unique = true)
    private String name;
    private String nation;
    private String position;
    private Integer age;
    private Integer mp;
    private Integer starts;
    private Double minutes;
    private Double goals;
    private Double assists;
    private Double pk;
    private Double yellowCards;
    private Double redCards;
    private Double xG;
    private Double xA;
    private String team;

    public Player(String name){
        this.name = name;
    }

    public Player(String name, String nation, String position, Integer age, Integer mp, Integer starts, Double minutes, Double goals, Double assists, Double pk, Double yellowCards, Double redCards, Double xG, Double xA, String team) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.minutes = minutes;
        this.goals = goals;
        this.assists = assists;
        this.pk = pk;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.xG = xG;
        this.xA = xA;
        this.team = team;
    }

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMinutes() {
        return minutes;
    }

    public void setMinutes(Double minutes) {
        this.minutes = minutes;
    }

    public Double getGoals() {
        return goals;
    }

    public void setGoals(Double goals) {
        this.goals = goals;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getPk() {
        return pk;
    }

    public void setPk(Double pk) {
        this.pk = pk;
    }

    public Double getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Double yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Double getRedCards() {
        return redCards;
    }

    public void setRedCards(Double redCards) {
        this.redCards = redCards;
    }

    public Double getxG() {
        return xG;
    }

    public void setxG(Double xG) {
        this.xG = xG;
    }

    public Double getxA() {
        return xA;
    }

    public void setxA(Double xA) {
        this.xA = xA;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", mp=" + mp +
                ", starts=" + starts +
                ", minutes=" + minutes +
                ", goals=" + goals +
                ", assists=" + assists +
                ", pk=" + pk +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                ", xG=" + xG +
                ", xA=" + xA +
                ", team='" + team + '\'' +
                '}';
    }
}
