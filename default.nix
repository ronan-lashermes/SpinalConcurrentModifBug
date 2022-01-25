with import <nixpkgs> {};

let
     pkgs = import (builtins.fetchGit {
         # Descriptive name to make the store path easier to identify                
         name = "pinned_nix_packages";                                                 
         url = "https://github.com/nixos/nixpkgs/";                       
         ref = "refs/21.01";                     
         rev = "a7ecde854aee5c4c7cd6177f54a99d2c1ff28a31";                                           
     }) {};
in

# Make a new "derivation" that represents our shell
stdenv.mkDerivation {
  name = "chisel";

  # The packages in the `buildInputs` list will be added to the PATH in our shell
  buildInputs = [
    pkgs.verilator
    pkgs.sbt
    pkgs.glibcLocales
  ];
}