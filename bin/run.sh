#!/usr/bin/env bash

# This variable contains absolute path of this `run.sh` script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

JAR_FILE="$DIR/../target/machine-0.0.1-SNAPSHOT.jar"
[ ! -f "$JAR_FILE" ] && echo " Please run $DIR/setup.sh" && exit 1;


_USAGE(){
    echo "Usage:  `basename $0` {input_json_file}}";    
  
}

[ $# -ne 1 ] && _USAGE && exit 1;


java -jar $DIR/../target/machine-0.0.1-SNAPSHOT.jar $1;


