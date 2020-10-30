package com.ehq.ehq.ehq.Modals;

import android.os.Parcel;
import android.os.Parcelable;

public class groupArtistModal implements Parcelable {

    private String name,memberNumber,phone,email,samleWork;

    public groupArtistModal() {
        this.name = "";
        this.memberNumber = "";
        this.phone = "";
        this.email = "";
        this.samleWork = "";
    }

    public groupArtistModal(String name, String memberNumber, String phone, String email, String samleWork) {
        this.name = name;
        this.memberNumber = memberNumber;
        this.phone = phone;
        this.email = email;
        this.samleWork = samleWork;
    }

    protected groupArtistModal(Parcel in) {
        name = in.readString();
        memberNumber = in.readString();
        phone = in.readString();
        email = in.readString();
        samleWork = in.readString();
    }

    public static final Creator<groupArtistModal> CREATOR = new Creator<groupArtistModal>() {
        @Override
        public groupArtistModal createFromParcel(Parcel in) {
            return new groupArtistModal(in);
        }

        @Override
        public groupArtistModal[] newArray(int size) {
            return new groupArtistModal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSamleWork() {
        return samleWork;
    }

    public void setSamleWork(String samleWork) {
        this.samleWork = samleWork;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(memberNumber);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(samleWork);
    }
}
