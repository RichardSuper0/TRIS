FROM gentoo/stage3:latest

RUN emerge-webrsync || emerge --sync
RUN eselect profile set 1

# OTTIMIZZAZIONI ESTREME
RUN echo 'CFLAGS="-Ofast -pipe -march=native -mtune=native \
    -funroll-loops -fomit-frame-pointer -flto \
        -funsafe-math-optimizations -ffast-math -fno-math-errno \
            -fno-trapping-math -frename-registers -fweb \
                -fpeel-loops -ftracer -fipa-pta -fdevirtualize-at-ltrans"' \
                    >> /etc/portage/make.conf && \
                        echo 'CXXFLAGS="${CFLAGS}"' >> /etc/portage/make.conf && \
                            echo 'MAKEOPTS="-j8"' >> /etc/portage/make.conf

                            # Installo SOLO bash
                            RUN emerge --verbose app-shells/bash

                            # Installo FASM64 manualmente
                            RUN mkdir -p /opt/fasm && \
                                cd /opt/fasm && \
                                    wget https://flatassembler.net/fasm-1.73.30.tgz && \
                                        tar xvf fasm-1.73.30.tgz && \
                                            chmod +x fasm && \
                                                ln -s /opt/fasm/fasm /usr/local/bin/fasm

                                                # Utente non-root
                                                RUN useradd -m dev && echo "dev ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers

                                                USER dev
                                                WORKDIR /home/dev