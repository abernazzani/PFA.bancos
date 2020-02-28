import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { LayoutComponent } from './shared/components/layout/layout.component';



const routes: Routes = [
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },
  {
    path: 'login', loadChildren: () => import('./modules/login/login.module').then(m => m.LoginModule),
  },
  {
    path: 'bancos', loadChildren: () => import('./modules/entidades-bancarias/entidades-bancarias.module').then(m => m.BancosModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'usuarios', loadChildren: () => import('./modules/usuarios/usuarios.module').then(m => m.UsuariosModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'sucursales', loadChildren: () => import('./modules/sucursales/sucursales.module').then(m => m.SucursalesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'bandas', loadChildren: () => import('./modules/bandas/bandas.module').then(m => m.BandasModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'jueces', loadChildren: () => import('./modules/jueces/jueces.module').then(m => m.JuecesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'delincuentes', loadChildren: () => import('./modules/delincuentes/delincuentes.module').then(m => m.DelincuentesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'asaltos', loadChildren: () => import('./modules/asaltos/asaltos.module').then(m => m.AsaltosModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'contrataciones', loadChildren: () => import('./modules/contrataciones/contrataciones.module').then(m =>  m.ContratacionesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'vigilantes', loadChildren: () => import('./modules/vigilantes/vigilantes.module').then(m =>  m.VigilantesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'inicio', loadChildren: () => import('./modules/inicio/inicio.module').then(m =>  m.InicioModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'condenas', loadChildren: () => import('./modules/condenas/condenas.module').then(m =>  m.CondenasModule),
    canActivate: [AuthGuard],
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
