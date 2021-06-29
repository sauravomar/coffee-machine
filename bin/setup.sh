#!/bin/bash - 


# Add script to:
# * Install dependencies
# * Build/Compile
# * Run Test Suit to validate
#
# After this is run, bin/run.sh
# should Just Work.

# This variable contains absolute path of this `run.sh` script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
$DIR/../mvnw clean install

