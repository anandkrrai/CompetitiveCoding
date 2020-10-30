package com.ehq.ehq.ehq.Modals;


import android.os.Parcel;
import android.os.Parcelable;

public class actorModal implements Parcelable {
  private String Name,
    Address,
    Phone,
    Email,
    Dob,
    Age,
    Language,
    Gender,
    Qualification,
    EyeColour,
    Height,
    Weight,
    MaritalStatus,
    Complexion,
    FormalEducation,
    WorkExperience,
    SampleWork,
    Image1,
    Image2,
    Image3,
    Image4;


    public actorModal() {
        Name="";
                Address="";
                Phone="";
                Email="";
                Dob="";
                Age="";
                Language="";
                Gender="";
                Qualification="";
                EyeColour="";
                Height="";
                Weight="";
                MaritalStatus="";
                Complexion="";
                FormalEducation="";
                WorkExperience="";
                SampleWork="";
    }


    public static final Creator<actorModal> CREATOR = new Creator<actorModal>() {
        @Override
        public actorModal createFromParcel(Parcel in) {
            return new actorModal(in);
        }

        @Override
        public actorModal[] newArray(int size) {
            return new actorModal[size];
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

    public String getEyeColour() {
        return EyeColour;
    }

    public void setEyeColour(String eyeColour) {
        EyeColour = eyeColour;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getComplexion() {
        return Complexion;
    }

    public void setComplexion(String complexion) {
        Complexion = complexion;
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

    public String getImage1() {
        return Image1;
    }

    public void setImage1(String image1) {
        Image1 = image1;
    }

    public String getImage2() {
        return Image2;
    }

    public void setImage2(String image2) {
        Image2 = image2;
    }

    public String getImage3() {
        return Image3;
    }

    public void setImage3(String image3) {
        Image3 = image3;
    }

    public String getImage4() {
        return Image4;
    }

    public void setImage4(String image4) {
        Image4 = image4;
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
        dest.writeString(EyeColour);
        dest.writeString(Height);
        dest.writeString(Weight);
        dest.writeString(MaritalStatus);
        dest.writeString(Complexion);
        dest.writeString(FormalEducation);
        dest.writeString(WorkExperience);
        dest.writeString(SampleWork);
        dest.writeString(Image1);
        dest.writeString(Image2);
        dest.writeString(Image3);
        dest.writeString(Image4);

    }

    private actorModal(Parcel in){

        Name = in.readString();
        Address = in.readString();
        Phone = in.readString();
        Email = in.readString();
        Dob = in.readString();
        Age = in.readString();
        Language = in.readString();
        Gender = in.readString();
        Qualification = in.readString();
        EyeColour = in.readString();
        Height = in.readString();
        Weight = in.readString();
        MaritalStatus = in.readString();
        Complexion = in.readString();
        FormalEducation = in.readString();
        WorkExperience = in.readString();
        SampleWork = in.readString();
        Image1 = in.readString();
        Image2 = in.readString();
        Image3 = in.readString();
        Image4 = in.readString();
    }
}


