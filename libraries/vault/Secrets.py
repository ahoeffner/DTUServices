import yaml
import argparse
import subprocess


class Secrets :
    @staticmethod
    def main() :
        parser = argparse.ArgumentParser(description="Load secrets")

        parser = argparse.ArgumentParser(
            description="Load secrets into HashiCorp Vault.",
            formatter_class=argparse.ArgumentDefaultsHelpFormatter
        )

        parser.add_argument(
            "-a", "--addr",
            type=str,
            default="http://127.0.0.1:8200",
            help="Vault server address"
        )

        parser.add_argument(
            "-u", "--user",
            type=str,
            default="dtu",
            help="The username to associate with these secrets"
        )

        parser.add_argument(
            "-f", "--file",
            type=str,
            default="secrets.yaml",
            help="Path to the secrets YAML file (default: secrets.yaml)"
        )

        args = parser.parse_args()
        secrets:Secrets = Secrets(args.addr,args.user)

        try:
            with open(args.file,"r") as f :
                config = yaml.safe_load(f)
                for key, value in config.items() :
                     secrets.load("",value)

        except FileNotFoundError:
                print("❌ secrets.yaml not found.")
        except Exception as e:
                print(f"❌ An error occurred: {e}")



    def __init__(self, url:str, user:str) :
        self.url = url
        self.user = user



    def load(self,path:str,node) :
        secrets:dict = {}

        for key, value in node.items() :
            if isinstance(value, dict) :
                parts = filter(None, [path, key])
                next = "/".join(parts)
                self.load(next,value)
            else :
                 secrets[key] = value

        if (secrets) :
            self.save(path,secrets)



    def save(self,path:str, data:any) :
        cmd = [
            "docker", "exec",
            "-e", f"VAULT_ADDR={self.url}",
            "-e", f"VAULT_TOKEN={self.user}",
            "vault",
            "vault", "kv", "put", "dtu/"+path
        ]

        for k, v in data.items():
            cmd.append(f"{k}={v}")

        subprocess.run(cmd, shell=False)



if __name__ == "__main__":
    Secrets.main()