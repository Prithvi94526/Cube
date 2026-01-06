# Cube

A low-level 3D modeling implementation in Java that constructs and manages a cube model using a triangular mesh architecture. Instead of relying on high-level graphics libraries, this project implements the mathematical foundations of 3D space from scratch.



## Core Features

* **Manual Mesh Construction:** Defines a cube not just as a box, but as a collection of faces composed of individual triangles.
* **Vector Mathematics:** Includes custom logic for `UnitVector` calculations, essential for determining surface normals and spatial orientation.
* **Granular Coordinate System:** Uses a `Point` class to manage 3D vertices ($x, y, z$) for precise object manipulation.

---

## How it Works

The project follows a hierarchical geometric structure to build complex shapes from simple primitives:

1.  **Points:** Defines the vertices in a 3D coordinate system using $(x, y, z)$ coordinates.
2.  **Triangles:** Connects three points to create the smallest flat surface unit (the basis of modern 3D rendering).
3.  **Faces:** Groups two triangles together to form one of the six square sides of the cube.
4.  **Cube:** Assembles the six faces into a complete, cohesive 3D object.

---

## Technical Details

* **Language:** Java
* **Math Foundation:** Custom Vector and Coordinate logic.
* **Rendering Logic:** Mesh-based (triangular).
