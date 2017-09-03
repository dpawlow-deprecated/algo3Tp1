#!/bin/sh

input=$1
output="$1promedio"
amount=$2

rm $output

for i in `seq 1 $amount`;
    do
		awk -F';' -v "I=$i" '$1 == I {print $2}' $input > tmp
		awk '{ sum += $1 } END { if (NR > 0) print sum / NR }' tmp >> $output
		rm tmp
	done    

