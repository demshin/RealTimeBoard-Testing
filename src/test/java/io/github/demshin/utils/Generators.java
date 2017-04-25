package io.github.demshin.utils;

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

    public static String randomSizeOfCompany() {
        String[] size = new String[10];
        size[0] = "1";
        size[2] = "2 - 5";
        size[3] = "6 - 10";
        size[4] = "11 - 25";
        size[5] = "26 - 50";
        size[6] = "51 - 500";
        size[7] = "501 - 1000";
        size[8] = "1001 - 5000";
        size[9] = "5001 or more";

        Random random = new Random();
        int n = random.nextInt(size.length);
        return size[n];
    }
}