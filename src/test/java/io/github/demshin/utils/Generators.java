package io.github.demshin.utils;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class Generators {

    public static String randomEmail() {
        return UUID.randomUUID().toString() + "@gmail.com";
    }

    public static String randomName() {
        return "Name" + UUID.randomUUID().toString();
    }

    public static String randomTeam() {
        return "Team" + UUID.randomUUID().toString();
    }

    public static String randomPassword() {
        return "Pass" + UUID.randomUUID().toString();
    }

    public static String randomRole() {
        String[] roles = new String[16];
        roles[0] = "CEO / Owner / Founder";
        roles[1] = "Product Owner";
        roles[2] = "Product Manager";
        roles[3] = "Project Manager";
        roles[4] = "UX Designer";
        roles[5] = "UI Designer";
        roles[6] = "Graphic Designer";
        roles[7] = "Agile coach / Scrum Master";
        roles[8] = "Account manager";
        roles[9] = "Business Developer";
        roles[10] = "Developer";
        roles[11] = "Freelancer";
        roles[12] = "Marketing / Communications / PR";
        roles[13] = "Teacher";
        roles[14] = "Student";
        roles[15] = "Other";

        Random random = new Random();
        int n = random.nextInt(roles.length);
        return roles[n];
    }

    public static String randomTeamSize() {
        String[] size = new String[10];
        size[0] = "Myself only";
        size[2] = "2 - 5 employees";
        size[3] = "6 - 10 employees";
        size[4] = "11 - 25 employees";
        size[5] = "26 - 50 employees";
        size[6] = "51 - 500 employees";
        size[7] = "501 - 1000 employees";
        size[8] = "1001 - 5000 employees";
        size[9] = "5000+ employees";

        Random random = new Random();
        int n = random.nextInt(size.length);
        return size[n];
    }

    public static String randomPhoneNumber() {
        Random random = new Random();

        int num1 = (random.nextInt(7) + 1) * 100 + (random.nextInt(8) * 10) + random.nextInt(8);
        int num2 = random.nextInt(743);
        int num3 = random.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
    }
}