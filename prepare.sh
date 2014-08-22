printf "Starting xvfb.. \n"
sudo start xvfb
printf "Receiving All Files... \n"
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/craftbukkit.jar --quiet
printf "Finished Receiving Libraries... \n"
printf "Finished Receiving Files. \n"
printf "Creating Required Directories... \n"
mkdir bin
printf "Finished Creating Required Directories. \n"
printf "Finished Preparing. \n"