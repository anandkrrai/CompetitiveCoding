package com.ehq.ehq.ehq.Modals;

import android.os.Parcel;
import android.os.Parcelable;

public class genericArtistModal implements Parcelable {

    private String Name,
            Address,
            Phone,
            Email,
            Dob,
            Age,
            Language,
            Gender,
            Qualification,
            FormalEducation,
            WorkExperience,
            SampleWork,
            workUploadLink,
            optionalLink1,
            optionalLink2;

    public genericArtistModal() {
        Name="";
        Address="";
        Phone="";
        Email="";
        Dob="";
        Age="";
        Language="";
        Gender="";
        Qualification="";
        FormalEducation="";
        WorkExperience="";
        SampleWork="";
        this.workUploadLink="";
        optionalLink1="";
        optionalLink2="";
    }

    public genericArtistModal(String name, String address, String phone, String email, String dob, String age, String language, String gender, String qualification, String formalEducation, String workExperience, String sampleWork, String workUploadLink) {
        Name = name;
        Address = address;
        Phone = phone;
        Email = email;
        Dob = dob;
        Age = age;
        Language = language;
        Gender = gender;
        Qualification = qualification;
        FormalEducation = formalEducation;
        WorkExperience = workExperience;
        SampleWork = sampleWork;
        this.workUploadLink = workUploadLink;
    }

    protected genericArtistModal(Parcel in) {
        Name = in.readString();
        Address = in.readString();
        Phone = in.readString();
        Email = in.readString();
        Dob = in.readString();
        Age = in.readString();
        Language = in.readString();
        Gender = in.readString();
        Qualification = in.readString();
        FormalEducation = in.readString();
        WorkExperience = in.readString();
        SampleWork = in.readString();
        workUploadLink= in.readString();
        optionalLink1=in.readString();
        optionalLink2=in.readString();
    }

    public static final Creator<genericArtistModal> CREATOR = new Creator<genericArtistModal>() {
        @Override
        public genericArtistModal createFromParcel(Parcel in) {
            return new genericArtistModal(in);
        }

        @Override
        public genericArtistModal[] newArray(int size) {
            return new genericArtistModal[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getFormalEducation() {
        return FormalEducation;
    }

    public void setFormalEducation(String formalEducation) {
        FormalEducation = formalEducation;
    }

    public String getWorkExperience() {
        return WorkExperience;
    }

    public void setWorkExperience(String workExperience) {
        WorkExperience = workExperience;
    }

    public String getSampleWork() {
        return SampleWork;
    }

    public void setSampleWork(String sampleWork) {
        SampleWork = sampleWork;
    }

    public String getWorkUploadLink() {
        return workUploadLink;
    }

    public void setWorkUploadLink(String workUploadLink) {
        this.workUploadLink = workUploadLink;
    }

    public static Creator<genericArtistModal> getCREATOR() {
        return CREATOR;
    }

    public String getOptionalLink1() {
        return optionalLink1;
    }

    public void setOptionalLink1(String optionalLink1) {
        this.optionalLink1 = optionalLink1;
    }

    public String getOptionalLink2() {
        return optionalLink2;
    }

    public void setOptionalLink2(String optionalLink2) {
        this.optionalLink2 = optionalLink2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Address);
        dest.writeString(Phone);
        dest.writeString(Email);
        dest.writeString(Dob);
        dest.writeString(Age);
        dest.writeString(Language);
        dest.writeString(Gender);
        dest.writeString(Qualification);
        dest.writeString(FormalEducation);
        dest.writeString(WorkExperience);
        dest.writeString(SampleWork);
        dest.writeString(workUploadLink);
        dest.writeString(optionalLink1);
        dest.writeString(optionalLink2);

    }
}
