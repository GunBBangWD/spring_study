package com.blue.bluearchive.constant;

public enum MemberStat {
    MEMBER,NOMEMBER,OUTMEMBER;
    public static MemberStat fromString(String value) {
        for (MemberStat stat : MemberStat.values()) {
            if (stat.name().equalsIgnoreCase(value)) {
                return stat;
            }
        }
        throw new IllegalArgumentException("Invalid MemberStat value: " + value);
    }
}
