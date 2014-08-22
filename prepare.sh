sudo start xvfb
Echo Receiving all Files...
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/craftbukkit.jar --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/bukkit.yml --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/banned-ips.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/banned-players.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/ops.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/whitelist.json --quiet
cd world
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world/region/r.-1.0.mca --quiet
cd ..
cd ..
cd world_nether
cd DIM-1
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.0.-1.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.-1.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.-1.-1.mca --quiet
cd ..
cd ..
cd ..
cd world_the_end
cd DIM-1
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.0.0.mca
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.0.-1.mca
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.-1.0.mca
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.-1.-1.mca
cd ..
cd ..
cd ..
Echo Finished Receiving.