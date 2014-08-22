printf "Starting xvfb.. \n"
sudo start xvfb
printf "Receiving All Files... \n"
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/craftbukkit.jar --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/bukkit.yml --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/banned-ips.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/banned-players.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/ops.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/whitelist.json --quiet
printf "Server Files Received... \n"
mkdir world
cd world
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world/session.lock --quiet
mkdir region
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world/region/r.-1.0.mca --quiet
printf "world Region Files Received... \n"
cd ..
cd ..
mkdir world_nether
cd world_nether
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/session.lock --quiet
mkdir DIM-1
cd DIM-1
mkdir region
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.0.-1.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.-1.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.-1.-1.mca --quiet
printf "world_nether Region Files Received... \n"
cd ..
cd ..
cd ..
mkdir world_the_end
cd world_the_end
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/session.lock --quiet
mkdir DIM-1
cd DIM-1
mkdir region
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.0.-1.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.-1.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.-1.-1.mca --quiet
printf "world_the_end Region Files Received... \n"
cd ..
cd ..
cd ..
printf "Finished Receiving. \n"
printf "Finished Preparing. \n"