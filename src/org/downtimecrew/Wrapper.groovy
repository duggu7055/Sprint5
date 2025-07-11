package org.downtimecrew


class Wrapper implements Serializable {
    def steps

    Wrapper(steps) {
        this.steps = steps
    }

    def init(String dir = 'terraform') {
        steps.echo "🔧 Running: terraform init in ${dir}"
        steps.dir(dir) {
            steps.sh 'terraform init'
        }
    }

    def validate(String dir = 'terraform') {
        steps.echo "🔧 Running: terraform validate in ${dir}"
        steps.dir(dir) {
            steps.sh 'terraform validate'
        }
    }

    def plan(String dir = 'terraform', String varfile = 'terraform.tfvars') {
        steps.echo "🔧 Running: terraform plan in ${dir} with ${varfile}"
        steps.dir(dir) {
            steps.sh "terraform plan -var-file=${varfile}"
        }
    }

    def applyTerraform(String dir = 'terraform', String varfile = 'terraform.tfvars') {
        steps.echo "🔧 Running: terraform apply in ${dir} with ${varfile}"
        steps.dir(dir) {
            steps.sh "terraform apply -auto-approve -var-file=${varfile}"
        }
    }

    def destroy(String dir = 'terraform', String varfile = 'terraform.tfvars') {
        steps.echo "🔧 Running: terraform destroy in ${dir} with ${varfile}"
        steps.dir(dir) {
            steps.sh "terraform destroy -auto-approve -var-file=${varfile}"
        }
    }
}
