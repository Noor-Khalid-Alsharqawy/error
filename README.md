# error
all app runs yielded in a connection to db problem, 
but i've just tried it again before uploading it to this repository,
and i was shocked as the resulted error was different this time,
although it indicates an error at the same location
(ie. line 62 in Surf_Fragment).
the new error is a casting error. firebase databases are built using json instead of csv.
after having a look at the new error, it seems to me that i'm supposed to cast to HashMaps,
then extract items from it. however, i'm not sure.
note: you will almost find other errors.
thanks in advance
