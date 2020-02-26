export enum Role {
    Admin = 1,
    Investigador = 2,
    Vigilante = 3
}

export const RoleLabel = new Map<number, string>([
    [Role.Admin, 'Admin'],
    [Role.Investigador, 'Investigador'],
    [Role.Vigilante, 'Vigilante']
]);