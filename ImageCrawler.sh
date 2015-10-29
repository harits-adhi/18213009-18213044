dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ddir="$dir/$1"
b="backup_$1"

wget -r   -A jpg,jpeg $1
[ ! -d $b ] && mkdir $b
	
rsync -a  $ddir/ $b