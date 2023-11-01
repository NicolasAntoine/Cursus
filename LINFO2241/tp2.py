import subprocess
import sys

#affinity->sets the CPU affinity for the iperf3 process
#zerocopy->transfer data from one memory location to another without any copy
#parallel->run on x threads to optimize the running

def launch_and_parse(parallel: int, zc: bool, aff: bool) -> float:
    output = subprocess.check_output(['iperf3','-c','localhost','-t','2'])
    decoded_output = output.decode(sys.stdout.encoding)
    tab = []
    string = ""
    for line in decoded_output:
        if (line == "\n"):
            tab.append(string)
            string = ""
        else : 
            string+=line
    answer = tab[len(tab)-3]
    #print(answer)
    return float(answer)



print(launch_and_parse(4,True,0))