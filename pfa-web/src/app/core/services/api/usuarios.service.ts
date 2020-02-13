import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Usuario } from '../../models/usuario';

@Injectable({ providedIn: 'root' })
export class UsuariosService {

    constructor(private apiService: ApiBaseService) {

    }

    async getAll(): Promise<Usuario[]> {
        return await this.apiService.get<Usuario[]>("/usuario/traerTodos");
    }

    async getPorId(id: number): Promise<Usuario> {
        let usuarios = await this.getAll();
        return usuarios.find(x => id == x.id);
    }
    
    async create(usuario: Usuario) {
        return await this.apiService.post("/usuario/crear", usuario);
    }

    async update(usuario: Usuario) {
        return await this.apiService.put("/usuario/guardar", usuario);
    }

    async delete(id: number) {
        return await this.apiService.delete(`/usuario/eliminarPorId/${id}`);
    }


}