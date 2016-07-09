The complete directory structure "freshlypressed" is created via "ionic start freshlypressed"
See tutorial: https://www.youtube.com/watch?v=sCnGSOaaZFo

You can follow the complete tutorial or skip a few things 
as I have added the most important starting point sources witin "hybrid-app-no-instrumentation".
Only the added or changed sources are included.

The folder "hybrid-app-with-instrumentation" contains the modified sources 
to include dynatrace UEM and pointing the application to our own java backend.

The folder "hybrid-app-dynamic-instrumentation" even goes a bit further. In stead of a script element in the index.html,
we now use javascript to create this script element dynamically. This imitates the behaviour of requirejs for example.
