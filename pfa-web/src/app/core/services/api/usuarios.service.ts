import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Usuario } from '../../models/usuario';

@Injectable({ providedIn: 'root' })
export class UsuariosService {

    constructor(private apiService: ApiBaseService) {

    }

    async getAll() {
        return this.apiService.get<Usuario[]>(`/usuario/traerTodos`);
    }

    async getById(id: number) {
        return this.apiService.get<Usuario>(`usuario/usuarioPorId/${id}`);
    }

    async create(usuario: Usuario) {
        await this.apiService.post("/usuario", {
            nombre: usuario.nombre,
            contraseña: usuario.password,
            rolID: usuario.rolID
        });
    }

    async update(usuario: Usuario) {
        await this.apiService.put("/usuario", {
            id: usuario.id,
            nombre: usuario.nombre,
            contraseña: usuario.password,
            rolID: usuario.rolID
        });
    }

    async delete(codigo: number) {
        await this.apiService.delete(`/usario/eliminarPorId/${codigo}`);
    }
}