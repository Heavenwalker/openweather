package com.techsaloniki.openweather.client.enums;

public enum SupportedZipCodeCountries {
    EN("en"),
    US("us");

    final String countryCode;

    SupportedZipCodeCountries(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public static SupportedZipCodeCountries fromCountryCode(String countryCode) {
        for (SupportedZipCodeCountries supportedZipCodeCountries : SupportedZipCodeCountries.values()) {
            if (supportedZipCodeCountries.getCountryCode().equals(countryCode)) {
                return supportedZipCodeCountries;
            }
        }
        return null;
    }
}
