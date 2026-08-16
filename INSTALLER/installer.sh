#!/bin/bash

echo "Welcome to DSCPP installer."

# Vai nella cartella DSCPP-1.0
cd ../DSCPP-1.0 || exit 1

# Estrai la zip che si trova già dentro DSCPP-1.0
echo "Extracting dscpp-1.0.zip..."
unzip dscpp-1.0.zip

# Dai permessi a setup.sh
chmod +x setup.sh

# Esegui setup.sh
./setup.sh