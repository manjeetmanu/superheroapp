package com.example.superheroapp;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

class PowerStats{
    private String id;
    private String name;
    private String intelligence;
    private String strength;
    private String speed;
    private String durability;
    private String power;
    private String combat;

    public PowerStats(String id, String name, String intelligence, String strength, String speed, String durability, String power, String combat) {
        this.id = id;
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDurability() {
        return durability;
    }

    public String getPower() {
        return power;
    }

    public String getCombat() {
        return combat;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public String getStrength() {
        return strength;
    }


    @NonNull
    @Override
    public String toString() {
        String str="\n\nSpeed : "+getSpeed()+"\n\nDurability : "+getDurability()+"\n\nPower : "+getPower()+"\n\nCombat : "+getCombat()+"\n\nIntelligence : "+getIntelligence()+"\n\nStrength : "+getStrength();
        return str;
    }
}
class Biography{
    private String id;
    private String name;
    @SerializedName("full-name")
    private String full_name;
    @SerializedName("alter-egos")
    private String alter_egos;
    private String[] aliases;
    @SerializedName("place-of-birth")
    private String place_of_birth;
    @SerializedName("first-appearance")
    private String first_appearance;
    private String publisher;
    private String alignment;

    public Biography(String id, String name, String full_name, String alter_egos, String[] aliases, String place_of_birth, String first_appearance, String publisher, String alignment) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.alter_egos = alter_egos;
        this.aliases = aliases;
        this.place_of_birth = place_of_birth;
        this.first_appearance = first_appearance;
        this.publisher = publisher;
        this.alignment = alignment;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getAlter_egos() {
        return alter_egos;
    }

    public String getAliases() {
        return Arrays.toString(aliases);
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public String getFirst_appearance() {
        return first_appearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAlignment() {
        return alignment;
    }

    @NonNull
    @Override
    public String toString() {
        String str="\n\nFull-Name : "+getFull_name()+"\n\nAlter-Egos : "+getAlter_egos()+"\n\nAliases : "+getAliases()+"\n\nPlace-Of-Birth : "+getPlace_of_birth()+"\n\nFirst-Appearance : "+getFirst_appearance()+"\n\nPublisher : "+getPublisher()+"\n\nAlignment : "+getAlignment();
        return str;
    }
}
class Appearance {
    private String id;
    private String name;
    private String gender;
    private String race;
    private String[] height;
    private String[] weight;
    @SerializedName("eye-color")
    private String eye_color;
    @SerializedName("hair-color")
    private String hair_color;

    public Appearance(String id, String name, String gender, String race, String[] height, String[] weight, String eye_color, String hair_color) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.eye_color = eye_color;
        this.hair_color = hair_color;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getHeight() {
        return Arrays.toString(height);
    }

    public String getWeight() {
        return Arrays.toString(weight);
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    @NonNull
    @Override
    public String toString() {
        String str="\n\nGender : "+getGender()+"\n\nRace : "+getRace()+"\n\nHeight : "+getHeight()+"\n\nWeight : "+getWeight()+"\n\nEye-color : "+getEye_color()+"\n\nHair-color : "+getHair_color();
        return str;
    }
}
class Work{
    private String id;
    private String name;
    private  String occupation;
    private String base;

    public Work(String id, String name, String occupation, String base) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.base = base;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getBase() {
        return base;
    }

    @NonNull
    @Override
    public String toString() {
        String str="\n\nOccupation : "+getOccupation()+"\n\nBase : "+getBase();
        return str;
    }
}
class Connection{
    private String id;
    private String name;
    private  String group_affiliation;
    private String relatives;

    public Connection(String id, String name, String group_affiliation, String relatives) {
        this.id = id;
        this.name = name;
        this.group_affiliation = group_affiliation;
        this.relatives = relatives;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup_affiliation() {
        return group_affiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    @NonNull
    @Override
    public String toString() {
        String str="\n\nGroup-Affiliation : "+getGroup_affiliation()+"\n\nRelatives : "+getRelatives();
        return str;
    }
}
class Image{
    private String id;
    private String name;
    private String url;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Image(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
class AllData{
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("powerstats")
    private PowerStats Stats;
    @SerializedName("biography")
    private Biography biograph;
    @SerializedName("appearance")
    private Appearance appe;
    @SerializedName("work")
    private Work wor;
    @SerializedName("connections")
    private Connection connn;
    @SerializedName("image")
    private Image imgs;

    public AllData(String id, String name, PowerStats stats, Biography biograph, Appearance appe, Work wor, Connection connn, Image imgs) {

        this.id = id;
        this.name = name;
        Stats = stats;
        this.biograph = biograph;
        this.appe = appe;
        this.wor = wor;
        this.connn = connn;
        this.imgs = imgs;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PowerStats getStats() {
        return Stats;
    }

    public Biography getBiograph() {
        return biograph;
    }

    public Appearance getAppe() {
        return appe;
    }

    public Work getWor() {
        return wor;
    }

    public Connection getConnn() {
        return connn;
    }

    public Image getImgs() {
        return imgs;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
class NewData{
    @SerializedName("results")
    private List<AllData> results;

    public NewData(List<AllData> results) {
        this.results = results;
    }

    public List<AllData> getResults() {
        return results;
    }
}

