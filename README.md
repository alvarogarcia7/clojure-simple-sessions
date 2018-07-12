# Simple Clojure Sessions

Some place where to play with clojure

## Some sessions

### Notes

Inspired by the ATM's withdrawal mechanism, I've experimented with the feeling of having a good-enough solution for grouping an amount in notes.

Example: I want to withdraw 50 EUR and the available notes are 50 and 20. The algorithm would recommend `[50]`

Example: I want to withdraw 80 EUR and the available notes are 50 and 20. The best effort algorithm would recommend `[50 20]` (for a total of 70), while the real ATM algorithm would suggest `[20 20 20 20]`

