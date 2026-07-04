# [Earliest Common Slot](https://www.geeksforgeeks.org/problems/earliest-common-slot/1)
## Medium
Given two lists of availability slots, slots1[][] and slots2[][], for two people. Each slot is represented as [start, end], and no two slots overlap within the same list. Given an integer d representing the required meeting duration, return the earliest common time slot having a length of at least d. If no such slot exists, return an empty array.
Examples:
Input: slots1[][] = [[10, 50], [60, 120], [140, 210]], slots2[][] = [[0, 15], [60, 70]], d = 8
Output: [60, 68]
Explanation: The earliest overlapping slot is [60, 70], which is long enough for an 8-minute meeting. Hence, the answer is [60, 68].
Input: slots1[][] = [[10, 50], [60, 120], [140, 210]], slots2[][] = [[0, 15], [60, 70]], d = 12Output: []Explanation: The only overlapping slot is [60, 70], whose length is 10. Since a 12-minute meeting cannot be scheduled, no valid slot exists.
Constraints:1 ≤ slots1.size(), slots2.size()&nbsp; ≤ 105-109 ≤ start &lt; end ≤ 1091 ≤ d ≤ 106