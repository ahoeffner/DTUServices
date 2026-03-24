# 1. Get the directory where this script is located
# $PSScriptRoot is a built-in variable that always points to the script's folder
$ScriptDir = $PSScriptRoot

# 2. Check if the directory is already in the PATH
# We split the PATH by semicolons and check for an exact match (case-insensitive)
$CurrentPath = [Environment]::GetEnvironmentVariable("PATH", "Process")
$PathArray = $CurrentPath -split ";"

if ($PathArray -notcontains $ScriptDir) 
{
    # Prepend the script directory to the PATH for the current session
    $env:PATH = "$ScriptDir;$env:PATH"
    Write-Host "Added to PATH: $ScriptDir" -ForegroundColor Cyan
} else 
{
    Write-Host "Already in PATH." -ForegroundColor Gray
}