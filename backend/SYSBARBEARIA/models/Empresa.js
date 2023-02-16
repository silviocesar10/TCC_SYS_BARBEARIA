import mongoose from "mongoose";
const { Schema } = mongoose;
const EmpresaSchema = new Schema(
	{
		 nome_empresa: {
            type: String,
            required: true,
            trim: true,
        },
			email:{
						type: String,
            required: true,
            trim: true,
			},
			senha: {
            type: String,
            required: true,
      },
			cnpj:{
						type: String,
            required: true,
            trim: true,
			},
		descricacao:{
						type: String,
            required: true,
            trim: true,
			},
		telefone:{
						type: String,
            required: true,
            trim: true,
			},
		endereco:{
						type: String,
            required: true,
            trim: true,
			},
		
	}
    { timestamps: true }
);
export default mongoose.model("Empresa", EmpresaSchema);