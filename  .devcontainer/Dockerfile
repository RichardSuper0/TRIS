# Installo SOLO bash e fasm
FROM gentoo/stage3:latest

RUN emerge --verbose \
    app-shells/bash \
        dev-lang/fasm

        # FIX: aggiungi fasm al PATH
        RUN ln -s /usr/share/fasm/fasm /usr/local/bin/fasm