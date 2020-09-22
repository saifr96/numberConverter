package com.qa.main;

public class NumberConverter {
    public void jordanDidThisOneButIStoleIt() {
        String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        String[] tens = { "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String[] hundreds = { "", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred",
                "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred" };
        for (int i = 0; i < 1000; i++) {
            if (i > 99 && i % 100 > 19) {
                System.out.println("" + hundreds[i / 100] + " " + tens[i / 10 % 10] + " " + units[i % 10]);
            } else if (i > 99) {
                System.out.println("" + hundreds[i / 100] + " " + units[i % 100]);
            } else if (i > 19) {
                System.out.println("" + tens[i / 10] + " " + units[i % 10]);
            } else if (i < 20) {
                System.out.println(units[i]);
            }
        }
    }

    public void someoneOnlineDidItWithACharArrayAndItIsGhastly(char[] num) {
        int len = num.length;

        if (len == 0) {
            System.out.println("empty string");
            return;
        }
        if (len > 4) {
            System.out.println("Length more than 4 is not supported");
            return;
        }

        String[] single_digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine" };

        String[] two_digits = new String[] { "", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen" };

        String[] tens_multiple = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                "eighty", "ninety" };

        String[] tens_power = new String[] { "hundred", "thousand" };

        System.out.print(String.valueOf(num) + ": ");

        if (len == 1) {
            System.out.println(single_digits[num[0] - '0']);
            return;
        }

        int x = 0;
        while (x < num.length) {

            if (len >= 3) {
                if (num[x] - '0' != 0) {
                    System.out.print(single_digits[num[x] - '0'] + " ");
                    System.out.print(tens_power[len - 3] + " ");
                }
                --len;
            }

            else {
                if (num[x] - '0' == 1) {
                    int sum = num[x] - '0' + num[x] - '0';
                    System.out.println(two_digits[sum]);
                    return;
                }

                else if (num[x] - '0' == 2 && num[x + 1] - '0' == 0) {
                    System.out.println("twenty");
                    return;
                }

                else {
                    int i = (num[x] - '0');
                    if (i > 0)
                        System.out.print(tens_multiple[i] + " ");
                    else
                        System.out.print("");
                    ++x;
                    if (num[x] - '0' != 0)
                        System.out.println(single_digits[num[x] - '0']);
                }
            }
            ++x;
        }
    }

    public void hereIsOneIMadeEarlier() {
        String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tens = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        // for every number from 1 to 1000
        for (int counter = 1; counter <= 1000; counter++) {
            // if we've not hit 1000
            if (counter != 1000) {
                // if the count is at 19 or lower
                if (counter <= 19) {
                    // just print the unique units as-is
                    System.out.println(units[counter]);
                }
                // if the count is between 20 and 99
                else if ((counter > 19) && (counter <= 99)) {
                    // divide count by 10 and print the entry in the tens array that corresponds
                    // then divide count by 10 and print the entry in the units array that
                    // corresponds with its remainder
                    // e.g. if 21, then:
                    // print (21/10 = 2) -> tens[2] -> "twenty"
                    // then (21%10 = 1) -> units[1] -> "one"
                    System.out.println(tens[counter / 10] + " " + units[counter % 10]);
                }
                // if the counter is between 100 and 999 and does end with 1-19
                else if ((counter > 99) && (counter % 100 <= 19)) {
                    // divide count by 100 and print the entry in the units array that corresponds
                    System.out.println(units[counter / 100] + " hundred " + units[counter % 100]);
                }
                // if the counter is between 100 and 999 and doesn't end with 1-19
                // word category
                else if ((counter > 99) && (counter % 100 > 19)) {
                    System.out.println(
                            units[counter / 100] + " hundred " + tens[counter % 100 / 10] + " " + units[counter % 10]);
                }
            } else {
                System.out.println("one thousand");
            }
        }
    }

}
